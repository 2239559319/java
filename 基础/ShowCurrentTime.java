public class ShowCurrentTime {
    public static void main(String[] args){
        long totalMilliseconds=System.currentTimeMillis();  //返回毫秒时间戳
        long totalSeconds=totalMilliseconds/1000;           //总秒数
        long currentSecond=totalSeconds%60;                 //现在显示的秒
        long totalMinutes=totalSeconds/60;                  //总分数
        long currentMinute=totalMinutes%60;                 //现在显示的分数
        long totalHours=totalMinutes/60;                  //总时数
        long currentHour=totalHours%24;                     //现在显示的时
        System.out.println(totalMilliseconds);
        System.out.println(currentHour+":"+currentMinute+":"+currentSecond);
    }
}
