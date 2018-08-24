
package conwaygame;

import javafx.util.Duration;

/**
 * Speed Control Cass allows insertion of variable speeds selected from the UI into the Game timeline
 * 
 * @author paultana
 *
 */
public class SpeedControl {
	
	//Speed mode required is passed as a string which is matched to differing durations in the timeline
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
