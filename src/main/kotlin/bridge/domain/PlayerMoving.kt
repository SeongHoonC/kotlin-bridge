package bridge.domain

class PlayerMoving {
    var movingRecord = mutableListOf<String>()

    fun insertMoving(move:String){
        movingRecord.add(move)
    }
}