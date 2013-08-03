 
package de.gammas.JfaceGenericsTest.parts;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;

import de.gammas.JfaceGenericsTest.model.MyDomainModel;
import de.gammas.JfaceGenericsTest.model.Person;

public class ListViewerPart {
	@Inject
	public ListViewerPart(Composite composite) {
		
		ListViewer<Person,MyDomainModel> listViewer = new ListViewer<Person,MyDomainModel>(composite);
		
		
		
		listViewer.setContentProvider(new IStructuredContentProvider<Person,MyDomainModel>() {

			public void dispose() {
				
			}


			public void inputChanged(Viewer<MyDomainModel> viewer,
					MyDomainModel oldInput, MyDomainModel newInput) {
				viewer.refresh();
			}


			public Person[] getElements(MyDomainModel inputElement) {
				
				Person[] result = new Person[1];
				List<Person> flatPersons = new ArrayList<Person>();
				flatPersons = ((MyDomainModel)inputElement).getFlatList();
			
				
				return flatPersons.toArray(result);
			}
			
		});
		
		listViewer.setInput(new MyDomainModel());
		
		listViewer.setLabelProvider(new LabelProvider<Person>(){
			@Override
			public String getText(Person element) {
				
				return element.getName();
			}
		});
		
	}
	
	
	
	@Focus
	public void onFocus() {
		//TODO Your code here
	}
	
	
}