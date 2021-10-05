package study.programmers.hash

class BestAlbum {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        val songMap = HashMap<String, MutableList<Song>>()
        val songPlayMap = HashMap<String, Int>()

        genres.forEachIndexed { index, genre ->
            val song = Song(index, plays[index])

            if (songMap[genre] !== null) {
                songMap[genre]?.add(song)
            } else {
                songMap[genre] = mutableListOf(song)
            }

            songPlayMap[genre] = (songPlayMap[genre] ?: 0) + plays[index]
        }

        songMap.forEach {
            it.value.sortByDescending { v -> v.play }
        }

        val answer = mutableListOf<Int>()
        songPlayMap.toList().sortedWith(compareByDescending { it.second }).forEach {
            val songList = songMap[it.first]
            val indexFilteredSongList = songList?.filterIndexed { index, song ->
                index < 2
            }

            if (indexFilteredSongList != null) {
                answer.addAll(indexFilteredSongList.map { song -> song.id })
            }
        }

        return answer.toIntArray()
    }
}

data class Song(
    var id: Int,
    var play: Int
)
