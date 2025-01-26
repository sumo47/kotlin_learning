fun main(){

    SharingWidget.incrementTwitterLike()
    SharingWidget.incrementTwitterLike()
    SharingWidget.incrementTwitterLike()
    SharingWidget.incrementFbLike()

    SharingWidget.display()


}

object SharingWidget{
    private var twitterLike = 0;
    private var fbLike = 0;

    fun incrementTwitterLike() = twitterLike++;
    fun incrementFbLike() = fbLike++;
    fun display() = println("FbLike = $fbLike , TwitterLike = $twitterLike")
}