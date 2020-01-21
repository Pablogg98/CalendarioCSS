package dad.javafx.calendario.ui;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import dad.javafx.componentes.MonthCalendar;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class CalendarioController implements Initializable {
	
	//model
	
	private IntegerProperty anioValue = new SimpleIntegerProperty();
	
	//view
	
	@FXML
	private GridPane view;

	@FXML
	private Label anio;

	@FXML
	private MonthCalendar mes1, mes2, mes3, mes4, mes5, mes6, mes7, mes8, mes9, mes10, mes11, mes12;

	public CalendarioController() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CalendarioView.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		anioValue.addListener((o,ov,nv) -> onCambio(nv));
		anio.textProperty().bind(anioValueProperty().asString());
		anioValue.set(LocalDate.now().getYear());
		mes1.setMonth(0);
		mes2.setMonth(1);
		mes3.setMonth(2);
		mes4.setMonth(3);
		mes5.setMonth(4);
		mes6.setMonth(5);
		mes7.setMonth(6);
		mes8.setMonth(7);
		mes9.setMonth(8);
		mes10.setMonth(9);
		mes11.setMonth(10);
		mes12.setMonth(11);
	}

	private void onCambio(Number nv) {
		mes1.setYear(nv.intValue());
		mes2.setYear(nv.intValue());
		mes3.setYear(nv.intValue());
		mes4.setYear(nv.intValue());
		mes5.setYear(nv.intValue());
		mes6.setYear(nv.intValue());
		mes7.setYear(nv.intValue());
		mes8.setYear(nv.intValue());
		mes9.setYear(nv.intValue());
		mes10.setYear(nv.intValue());
		mes11.setYear(nv.intValue());
		mes12.setYear(nv.intValue());
	}

	@FXML
	void onLessAction(ActionEvent event) {
		anioValue.set(getAnioValue()-1);
	}

	@FXML
	void onPlusAction(ActionEvent event) {
		anioValue.set(getAnioValue()+1);
	}
	
	public GridPane getView() {
		return view;
	}

	public final IntegerProperty anioValueProperty() {
		return this.anioValue;
	}
	

	public final int getAnioValue() {
		return this.anioValueProperty().get();
	}
	

	public final void setAnioValue(final int anioValue) {
		this.anioValueProperty().set(anioValue);
	}

}
