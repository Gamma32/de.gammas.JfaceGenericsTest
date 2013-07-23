package de.gammas.JfaceGenericsTest.parts;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import de.gammas.JfaceGenericsTest.model.Person;

public class SamplePart {

	@PostConstruct
	public void createComposite(Composite parent) {
		parent.setLayout(new GridLayout());
		ComboViewer<Person, List<Person>> comboViewer = new ComboViewer<Person, List<Person>>(
				parent);
		List<Person> content = new ArrayList<Person>();

		content.add(new Person("Peter", new Date()));
		content.add(new Person("Hans", new Date()));

		comboViewer
				.setContentProvider(new IStructuredContentProvider<Person, List<Person>>() {

					public void inputChanged(Viewer<List<Person>> viewer,
							List<Person> oldInput, List<Person> newInput) {
						// TODO Auto-generated method stub

					}

					public void dispose() {

					}

					public Person[] getElements(List<Person> inputElement) {

						List<Person> personList = inputElement;
						return personList.toArray(new Person[personList.size()]);
					}

				});

		comboViewer.setLabelProvider(new LabelProvider<Person>() {
			@Override
			public String getText(Person element) {
				return element.getName();
			}
		});
		comboViewer.setInput(content);

	}

	@Focus
	public void setFocus() {
	}
}
