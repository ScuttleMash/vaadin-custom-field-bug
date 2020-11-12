package com.example.application.views.helloworld;

import com.example.application.views.main.MainView;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "hello", layout = MainView.class)
@PageTitle("Hello World")
@CssImport("./styles/views/helloworld/hello-world-view.css")
@RouteAlias(value = "", layout = MainView.class)
public class HelloWorldView extends HorizontalLayout {

	private ZonedDateTimeCustomField zonedDateTimeCustomField;

	public HelloWorldView() {
		setId("hello-world-view");

		zonedDateTimeCustomField = new ZonedDateTimeCustomField();

		add(zonedDateTimeCustomField);
		setVerticalComponentAlignment(Alignment.END, zonedDateTimeCustomField);
	}
}
