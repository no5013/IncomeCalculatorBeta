/**
 * Use for calculate the income
 */
import java.util.List;

public class MoneyCalculator {
	
	/**
	 * Calculate money from the given layer. If produce outcome is finished, the total outcome will increase from that layer's outcome
	 * 
	 * @param gameTime
	 * @param layers
	 * @return
	 */
	public int calculateMoney(int gameTime,List<Layer> layers){
		int outcome=0;
		for(Layer l : layers){
			if(gameTime%l.getProduceTime()<=100){ // STILL BUG WHEN TIME GROW BIGGER.
				outcome+=l.getOutcome();
				System.out.printf("GET %d FROM %s AT %d\n",l.getOutcome(),l.getName() , gameTime);
			}
		}

		return outcome;

	}

}
