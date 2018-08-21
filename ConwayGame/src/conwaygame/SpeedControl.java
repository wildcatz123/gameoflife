/**
 * 
 */
package conwaygame;

import javafx.util.Duration;

/**
 * @author paultana
 *Speed control
 */
public class SpeedControl {

	public Duration getNewDuration(String mode) {
		Duration duration; 
		if (mode.equalsIgnoreCase("Slow")) {
			duration = new Duration(900);
		} else if (mode.equalsIgnoreCase("Medium")) {
			duration = new Duration(200);
		} else if (mode.equalsIgnoreCase("Fast")){
			duration = new Duration(70);
		}else if (mode.equalsIgnoreCase("Fastest")){
			duration = new Duration(5);
		}else { //set default duration
			duration = new Duration(100);			
		}
		return duration;
	}
}
