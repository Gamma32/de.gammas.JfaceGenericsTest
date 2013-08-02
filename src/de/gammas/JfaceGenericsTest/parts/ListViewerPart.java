 
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
		
		ListViewer listViewer = new ListViewer(composite);
		
		
		
		listViewer.setContentProvider(new IStructuredContentProvider() {

			public void dispose() {
				
			}


			public Object[] getElements(Object inputElement) {
				
				List<Person> flatPersons = new ArrayList<Person>();
				flatPersons = ((MyDomainModel)inputElement).getFlatList();
			
				
				return flatPersons.toArray();
			}


			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		listViewer.setInput(new MyDomainModel());
		
		listViewer.setLabelProvider(new LabelProvider(){
			@Override
			public String getText(Object element) {
				
				return ((Person)element).getName();
			}
		});
		
	}
	
	
	
	@Focus
	public void onFocus() {
		//TODO Your code here
	}
	
	
}