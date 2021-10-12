package study.programmers.weekly;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Weekly10 {

    static class IntersectionPointList {
        private final ArrayList<Point> pointList = new ArrayList<>();

        public void addPoint(Point point) {
            pointList.add(point);
        }

        public Point getLeftPoint() throws NullPointerException {
            Optional<Point> optionalPoint = pointList.stream().min(Comparator.comparingDouble(Point::getX));
            if (optionalPoint.isEmpty()) {
                throw new NullPointerException();
            }
            return optionalPoint.get();
        }

        public Point getRightPoint() throws NullPointerException {
            Optional<Point> optionalPoint = pointList.stream().max(Comparator.comparingDouble(Point::getX));
            if (optionalPoint.isEmpty()) {
                throw new NullPointerException();
            }
            return optionalPoint.get();
        }

        public Point getTopPoint() throws NullPointerException {
            Optional<Point> optionalPoint = pointList.stream().max(Comparator.comparingDouble(Point::getY));
            if (optionalPoint.isEmpty()) {
                throw new NullPointerException();
            }
            return optionalPoint.get();
        }

        public Point getBottomPoint() throws NullPointerException {
            Optional<Point> optionalPoint = pointList.stream().min(Comparator.comparingDouble(Point::getY));
            if (optionalPoint.isEmpty()) {
                throw new NullPointerException();
            }
            return optionalPoint.get();
        }

        public Set<String> getPointSet() {
            return pointList.stream().map(p -> p.getX() + "-" + p.getY()).collect(Collectors.toSet());
        }
    }

    static class Point {
        private final double x;
        private final double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }
    }

    public String[] solution(int[][] line) {
        IntersectionPointList intersectionPointList = new IntersectionPointList();
        addPoints(line, intersectionPointList);

        Set<String> pointSet = intersectionPointList.getPointSet();

        if(pointSet.isEmpty()){
            return new String[]{"*"};
        }

        Point leftPoint = intersectionPointList.getLeftPoint();
        Point rightPoint = intersectionPointList.getRightPoint();
        Point topPoint = intersectionPointList.getTopPoint();
        Point bottomPoint = intersectionPointList.getBottomPoint();

        String result = getPointString(pointSet, leftPoint, rightPoint, topPoint, bottomPoint);
        return result.split(System.lineSeparator());
    }

    private String getPointString(Set<String> pointSet, Point leftPoint, Point rightPoint, Point topPoint, Point bottomPoint) {
        StringBuilder stringBuilder = new StringBuilder();
        for (double y = topPoint.getY(); y >= bottomPoint.getY(); y--) {
            for (double x = leftPoint.getX(); x <= rightPoint.getX(); x++) {
                if (pointSet.contains(x + "-" + y)) {
                    stringBuilder.append("*");
                } else {
                    stringBuilder.append(".");
                }
            }
            stringBuilder.append(System.lineSeparator());
        }

        return stringBuilder.toString();
    }

    private void addPoints(int[][] line, IntersectionPointList intersectionPointList) {
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                addPoint(line[i], line[j], intersectionPointList);
            }
        }
    }

    private void addPoint(int[] line1, int[] line2, IntersectionPointList intersectionPointList) {
        int numerator = (line1[0] * line2[1] - line1[1] * line2[0]);
        if (numerator == 0) {
            return;
        }

        double x = getX(line1, line2, numerator);
        if (hasPoint(x)) {
            return;
        }
        x = removeMinus(x);

        double y = getY(line1, line2, numerator);
        if (hasPoint(y)) {
            return;
        }
        y = removeMinus(y);

        intersectionPointList.addPoint(new Point(x, y));
    }

    private double removeMinus(double no) {
        if (no == -0.0) {
            no = 0.0;
        }
        return no;
    }

    private double getY(int[] line1, int[] line2, int numerator) {
        return ((double) (line1[2] * line2[0] - line1[0] * line2[2])) / numerator;
    }

    private boolean hasPoint(double no) {
        return Math.abs(no - (int) no) > 0.0;
    }

    private double getX(int[] line1, int[] line2, int numerator) {
        return ((double) (line1[1] * line2[2] - line1[2] * line2[1])) / numerator;
    }
}
