package de.gammas.JfaceGenericsTest.parts;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import de.gammas.JfaceGenericsTest.model.Person;

public class SamplePart {

	private List<Person> content;
	private ComboViewer<Person, List<Person>> comboViewer;

	class PersonFilter extends ViewerFilter{

		@Override
		public boolean select(Viewer viewer, Object parentElement,
				Object element) {
			
			Person person = (Person) element;
			
			return person.getName().matches(".*e.*");
		}
		
	}
	
	@PostConstruct
	public void createComposite(Composite parent) {
		parent.setLayout(new GridLayout());
		comboViewer = new ComboViewer<Person, List<Person>>(parent);
		content = new ArrayList<Person>();

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


		comboViewer.addFilter(new PersonFilter());
		
		
		comboViewer.setLabelProvider(new LabelProvider<Person>() {
			@Override
			public String getText(Person element) {
				return element.getName();
			}
		});
		comboViewer.setInput(content);

		Button addAnother = new Button(parent, SWT.None);
		addAnother.setText("Add");
		addAnother.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				addPerson(new Person("Meli", new Date()));
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

	public void addPerson(Person person) {
		this.content.add(person);
		this.comboViewer.refresh();

	}

	@Focus
	public void setFocus() {
	}
}
