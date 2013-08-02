package de.gammas.JfaceGenericsTest.parts;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import de.gammas.JfaceGenericsTest.model.MyDomainModel;
import de.gammas.JfaceGenericsTest.model.Person;

public class TableViewerPart {
	@Inject
	public TableViewerPart(Composite composite) {
		TableViewer tableViewer = new TableViewer(composite);

		tableViewer.setContentProvider(new IStructuredContentProvider() {

			public void dispose() {
				
			}


			public Person[] getElements(Object inputElement) {
				Person[] persons = ((MyDomainModel)inputElement).getRoot();
				Person[] flatPersonsArray = new Person[1];
				List<Person> flatPersons = new ArrayList<Person>();
				
				flatTree(persons, flatPersons);
			
				
				return (Person[]) flatPersons.toArray(flatPersonsArray);
			}


			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		class PersonFilter extends ViewerFilter{

			@Override
			public boolean select(Viewer viewer, Object parentElement,
					Object element) {
				
				Person person = (Person) element;
				
				return person.getName().matches(".*e.*");
			}
			
		}
		
		class MySelectionChangedListner implements ISelectionChangedListener{

			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				
				System.out.println(((Person)selection.getFirstElement()).getName());
			}
			
		}
		
		tableViewer.addFilter(new PersonFilter());
		tableViewer.addSelectionChangedListener(new MySelectionChangedListner());
		

		TableViewerColumn column = new TableViewerColumn(tableViewer, SWT.NONE); 
		
		column.setLabelProvider(new ColumnLabelProvider(){
			@Override
			public String getText(Object element) {
				// TODO Auto-generated method stub
				return ((Person)element).getName();
			}
		});
		
		column.getColumn().setWidth(200);
		
		column.getColumn().setText("Name:");
		column.setEditingSupport(new FirstNameEditingSupport(tableViewer));


		
		column = new TableViewerColumn(tableViewer, SWT.NONE); 
		
		column.setLabelProvider(new ColumnLabelProvider(){
			@Override
			public String getText(Object element) {
				// TODO Auto-generated method stub
				return ((Person)element).getBirthdate().toString();
			}
		});
		
		column.getColumn().setWidth(200);
		
		column.getColumn().setText("Date:");



		tableViewer.setInput(new MyDomainModel());
		
		tableViewer.refresh();
	}
	
	private void flatTree(Object[] persons, List<Person> flatPersons){
		for (int i = 0; i < persons.length; i++) {
			Person person = (Person) persons[i];
			flatPersons.add(person);
			if(person.getChildren() != null){
				flatTree(person.getChildren().toArray(),flatPersons);
			}
		}
	}

	private Person[] generateInput() {
		Person hubert = new Person("Hubert", new Date());
		Person[] root = { hubert };

		Person walli = new Person("Walli", new Date());
		hubert.addChildren(walli);

		Person ulli = new Person("Ulli", new Date());
		hubert.addChildren(ulli);

		Person werner = new Person("Werner", new Date());
		hubert.addChildren(werner);

		Person laura = new Person("Laura", new Date());
		werner.addChildren(laura);

		Person hendrik = new Person("Hendrik", new Date());
		werner.addChildren(hendrik);

		return root;
	}

	public class FirstNameEditingSupport extends EditingSupport {

		  private final TableViewer viewer;

		  public FirstNameEditingSupport(TableViewer viewer) {
		    super(viewer);
		    this.viewer = viewer;
		  }

		  @Override
		  protected CellEditor getCellEditor(Object element) {
		    return new TextCellEditor(viewer.getTable());
		  }

		  @Override
		  protected boolean canEdit(Object element) {
		    return true;
		  }

		  @Override
		  protected Object getValue(Object element) {
		    return ((Person) element).getName();
		  }

		  @Override
		  protected void setValue(Object element, Object value) {
		    ((Person) element).setName(String.valueOf(value));
		    viewer.update(element, null);
		  }
		} 
	
	@Focus
	public void onFocus() {
		// TODO Your code here
	}

}