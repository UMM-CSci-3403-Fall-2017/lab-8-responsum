package mpd;

public class ThreadedMinimumPairwiseDistance implements MinimumPairwiseDistance {

    @Override
    public int minimumPairwiseDistance(int[] numbers) {
      Minimum minimum = new Minimum();
      Thread lowerleft = new Tread(new lowerleft(numbers, min));
      Thread bottomright = new Thread(new bottomright(numbers, min));
      Thread topright = new Thread(new topright(numbers, min));
      Thread cetner = new Thread(new center(numbers, min));
      // Initalizing the threads.
      lowerleft.start();
      bottomright.start();
      topright.start();
      cetner.start();
      //Joining all of the threads together needed since we are multithreading
      try{
        lowerleft.join();
        bottomright.join();
        topright.join();
        center.join();
      }
      catch(InterruptedException noGo){
        noGO.printStactTrace();
      }
      return minimum.getMinimum();
    }
    //Building a class to keep track of the Minimum, IE pairwise distance
    private class Minimum{
      private int minimum = Integer.MAX_VALUE;

      public synchronized void setMinimum(int checking){
        if(checking < this.minimum){
          this.minimum = checking;
        }
      }
      public int getMinimum(){
        return this.minimum;
      }
    }

    private class lowerleft implements Runnable{
      private int[] numbers;
      Minimum minimum;

      private lowerleft(int[] numbers, Minimum minimum){
        this.numbers = numbers;
        this.minimum = minimum;
      }
      @Override
      public void run(){
        int lengthofnumbers = numbers.length;
        int checking = Integer.MAX_VALUE;

        for(int i=0; i< lengthofnumbers/2; i++){
          for(int j=0; j<i; j++){
            if(Math.abs(numbers[i] - numbers[j]) < checking){
              checking = Math.abs(numbers[i] - numbers[j]);
            }
          }
        }
        minimum.setMinimum(checking);
      }
    }

    private class bottomright implements Runnable{
      private int[] numbers;
      Minimum minimum;

      private bottomright(int[] numbers, Minimum minimum){
        this.numbers = numbers;
        this.minimum = minimum;
      }
      @Override
      public void run(){
        int lengthofnumbers = numbers.length;
        int checking = Integer.MAX_VALUE;

        for(int i=lengthofnumbers/2; i<1 lengthofnumbers; i++){
          for(int j=0; j<i-(lengthofnumbers/2); j++){
            if(Math.abs(numbers[i] - numbers[j]) < checking){
              checking = Math.abs(numbers[i] - numbers[j]);
            }
          }
        }
        minimum.setMinimum(checking);
      }
    }
    private class topright implements Runnable{
      private int[] numbers;
      Minimum minimum;

      private topright(int[] numbers. Minimum minimum){
        this.numbers = numbers;
        this.minimum = minimum;
      }
      @Override
      public void run(){
        int lengthofnumbers = numbers.length;
        int checking = Integer.MAX_VALUE;

        for(int i=lengthofnumbers/2; i<len; i++){
          for(int j=lengthofnumbers/2; j<i; j++){
            if(Math.abs(numbers[i] - numbers[j]) < checking){
              checking = Math.abs(numbers[i] - numbers[j]);
            }
          }
        }
        minimum.setMinimum(checking);
      }
    }

    private class cetner implements Runnable{
      private int[] numbers;
      Minimum minimum;

      private center(int[] numbers, Minimum minimum){
        this.numbers = numbers;
        this.minimum = minimum;
      }
      @Override
      public void run(){
        int lengthofnumbers = numbers.length;
        int checking = Integer.MAX_VALUE;

        for(int i=(lengthofnumbers/2); i<lengthofnumbers; i++){
          for(int j= i-(lengthofnumbers/2); j<(lengthofnumbers/2); j++){
            if(Math.abs(numbers[i] - numbers[j]) < checking){
              checking = Math.abs(numbers[i] - numbers[j]);
            }
          }
        }
        min.setMinimum(checking);
      }
    }
}
