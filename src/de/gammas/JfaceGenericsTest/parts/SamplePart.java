
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
		ComboViewer<Person> comboViewer = new ComboViewer<Person>(parent);
		List<Person> content = new ArrayList<Person>();		
		
		content.add(new Person("Peter", new Date()));
		content.add(new Person("Hans", new Date()));
		
		comboViewer.setContentProvider(new IStructuredContentProvider<Person>() {
			private Person[] elements;
			
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
				
			}
			
			public void dispose() {
				
			}
			
			public Person[] getElements(Object inputElement) {
				
				List<Person> personList =  (List<Person>) inputElement;
				return personList.toArray(new Person[personList.size()]);
			}
		});
		
		comboViewer.setLabelProvider(new LabelProvider<Person>(){
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
