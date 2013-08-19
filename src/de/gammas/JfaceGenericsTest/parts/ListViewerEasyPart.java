
package de.gammas.JfaceGenericsTest.parts;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import de.gammas.JfaceGenericsTest.model.Person;

public class ListViewerEasyPart {
//	private List<Person> content;
//	private ListViewer<Person, List<Person>> listViewer;
//
//
//	@Inject
//	public ListViewerEasyPart(Composite parent) {
//
//	    parent.setLayout(new GridLayout());
//	    listViewer = new ListViewer<Person, List<Person>>(parent);
//	    content = new ArrayList<Person>();
//
//	    content.add(new Person("Peter", new Date()));
//	    content.add(new Person("Lars", new Date()));
//
//	    listViewer
//	            .setContentProvider(new IStructuredContentProvider<Person, List<Person>>() {
//
//	                public void inputChanged(Viewer<List<Person>> viewer,
//	                        List<Person> oldInput, List<Person> newInput) {
//	                    // TODO Auto-generated method stub
//
//	                }
//
//	                public void dispose() {
//
//	                }
//
//	                public Person[] getElements(List<Person> inputElement) {
//
//	                    List<Person> personList = inputElement;
//	                    return personList.toArray(new Person[personList.size()]);
//	                }
//
//	            });
//
//
//
//
//	    listViewer.setLabelProvider(new LabelProvider<Person>() {
//	        @Override
//	        public String getText(Person element) {
//	            return element.getName();
//	        }
//	    });
//	    listViewer.setInput(content);
//	}



	@Focus
	public void onFocus() {
		//TODO Your code here
	}


}