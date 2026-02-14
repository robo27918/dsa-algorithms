public class HelloGoodbye{
    public static void main(String[]args){
        if(args.length !=2){
            System.out.println("Please pass in two commandline-args");

            return;
        }
        System.out.println("Hello " + args[0] + " and " + args[1] +".");
        System.out.println("Goodbye " + args[0] + " and " + args[1] + ".");
    }

}
