package mpd;

public class ThreadedMinimumPairwiseDistance implements MinimumPairwiseDistance {

    @Override
    public int minimumPairwiseDistance(int[] values) {
      Thread lowerleft = new Tread(new lowerleft(values, min));
      Thread bottomright = new Thread(new bottomright(values, min));
      Thread topright = new Thread(new topright(values, min));
      Thread cetner = new Thread(new center(vales, min));
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
      return min.getMin();
    }
//Need to add the acutall code to handle of different thread called, proprly similar to that of peters code in the workup
