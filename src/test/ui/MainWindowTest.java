package ui;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ui.MainWindow;

public class MainWindowTest {
	private FrameFixture window;
	
	@BeforeEach
	protected void onSetUp() {
		  MainWindow frame = GuiActionRunner.execute(() -> new MainWindow());	
		  window = new FrameFixture(frame);
		  window.show(); // shows the frame to test
	}
	
	@Test
	protected void buttonsPresentAndClickable() {
		window.button(UiUtils.MatchButtonByName("Reserve a Room"));
		window.button(UiUtils.MatchButtonByName("View booked Rooms"));
	}
	
	@Test
	protected void reserveButtonNavigatesToCorrectPanel() {
		window.panel(UiUtils.MatchPanelByName("Main"));
		window.button(UiUtils.MatchButtonByName("Reserve a Room")).click();
		window.panel(UiUtils.MatchPanelByName("Reserve a Room"));
	}
	
	@Test
	protected void viewButtonNavigatesToCorrectPanel() {
		window.panel(UiUtils.MatchPanelByName("Main"));
		window.button(UiUtils.MatchButtonByName("View booked Rooms")).click();
		window.panel(UiUtils.MatchPanelByName("Booked Rooms"));
	}
	
	
	
	@AfterEach
	protected void cleanUp() {
		window.cleanUp();
	}

}
