import org.apache.log4j.Logger;

/*
模拟产生日志
 */
public class LoggerGenerator {
    private static Logger logger = Logger.getLogger(LoggerGenerator.class.getName());
    public static void main(String[] args) throws Exception {
        int index = 0;
        while (true){
            Thread.sleep(1000);
            logger.info("value is :"+index++);
        }
    }
}
