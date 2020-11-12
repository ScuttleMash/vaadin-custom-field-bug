package com.example.application.views.helloworld;

import static java.time.format.DateTimeFormatter.ofPattern;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ZonedDateTimeCustomField extends CustomField<LocalDateTime> {

	private DatePicker datePicker;
	private DateTimePicker dateTimePicker;

	public ZonedDateTimeCustomField() {
		datePicker = new DatePicker("DatePicker");
		datePicker.addValueChangeListener(this::dateListener);
		dateTimePicker = new DateTimePicker("DateTimePicker");
		dateTimePicker.addValueChangeListener(this::dateTimeListener);

		add(new VerticalLayout(datePicker, dateTimePicker));
	}

	private void dateListener(ComponentValueChangeEvent<DatePicker, LocalDate> event) {
		String input = ofPattern("dd/MM/yy").format(event.getValue());
		System.out.println(String.format("--- dateListener w/ value %s", input));
	}

	private void dateTimeListener(ComponentValueChangeEvent<DateTimePicker, LocalDateTime> event) {
		String input = ofPattern("dd/MM/yy - HH:mm").format(event.getValue());
		System.out.println(String.format("--- dateTimeListener w/ value %s", input));
	}

	@Override
	protected LocalDateTime generateModelValue() {
		String dateInput = datePicker.getValue() != null ? ofPattern("dd/MM/yy").format(datePicker.getValue()) : null;
		String dateTimeInput =
				dateTimePicker.getValue() != null ? ofPattern("dd/MM/yy - HH:mm").format(dateTimePicker.getValue()) : null;
		System.out.println(
				String.format("--- generateModelValue w/ DatePicker %s and DateTimePicker %s", dateInput, dateTimeInput));

		if (dateTimePicker.getValue() == null) {
			return null;
		}

		return dateTimePicker.getValue();
	}

	@Override
	protected void setPresentationValue(LocalDateTime localDateTime) {
		dateTimePicker.setValue(localDateTime);
	}
}
