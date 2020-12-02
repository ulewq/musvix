package panel_glowny;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderListener implements ChangeListener {

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		       
		volume = volume_slider.getValue(); 
	}

}
