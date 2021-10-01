package study.programmers.level2;

import java.util.*;
import java.util.stream.Collectors;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/72411
 * 2021-10-1
 */

public class MenuRenewal {

  private static class Course implements Comparable<Course> {
    private final String name;
    private int ordererCount;

    public Course(String name) {
      this.name = name;
      this.ordererCount = 1;
    }

    @Override
    public int compareTo(Course o) {

      if (ordererCount == o.ordererCount) {
        return name.compareTo(o.name);
      }

      return Integer.compare(o.ordererCount, ordererCount);
    }

    public String getName() {
      return name;
    }

    public int getOrdererCount() {
      return ordererCount;
    }

    public void increaseOrdererCount() {
      ordererCount++;
    }
  }

  public String[] solution(String[] orders, int[] course) {

    Map<String, Course> courseMap = new HashMap<>();

    List<String> courseList = new ArrayList<>();

    for (int courseCount : course) {
      courseMap.clear();
      addCourse(orders, courseMap, courseList, courseCount);
    }

    Collections.sort(courseList);

    return courseList.toArray(new String[0]);
  }

  private void addCourse(String[] orders, Map<String, Course> courseMap, List<String> courseList, int courseCount) {
    for (String order : orders) {
      combineMenu(courseMap, order, courseCount, "", 0);
    }

    int ordererCount = getMaxOrdererCount(courseMap);

    List<String> newCourseList = courseMap.values().stream()
      .filter(c -> c.ordererCount == ordererCount && c.ordererCount > 1)
      .map(Course::getName)
      .collect(Collectors.toList());
    courseList.addAll(newCourseList);
  }

  private int getMaxOrdererCount(Map<String, Course> courseMap) {
    Optional<Course> optionalCourse = courseMap.values().stream().max(Comparator.comparingInt(c -> c.ordererCount));

    if (optionalCourse.isEmpty()) {
      return 0;
    }

    return optionalCourse.get().getOrdererCount();
  }

  private void combineMenu(Map<String, Course> courseMap, String order, int courseCount, String course, int index) {

    if (courseCount == course.length()) {
      char[] chars = course.toCharArray();
      Arrays.sort(chars);
      String courseString = new String(chars);
      if (courseMap.containsKey(courseString)) {
        courseMap.get(courseString).increaseOrdererCount();
      } else {
        courseMap.put(courseString, new Course(courseString));
      }
      return;
    }

    for (int i = index; i < order.length(); i++) {
      char menu = order.charAt(i);
      if (!course.contains(String.valueOf(menu))) {
        combineMenu(courseMap, order, courseCount, course + menu, i + 1);
      }
    }
  }
}
