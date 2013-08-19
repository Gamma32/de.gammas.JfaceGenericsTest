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
//	public TableViewerPart(Composite composite) {
//		TableViewer<Person,MyDomainModel> tableViewer = new TableViewer<Person,MyDomainModel>(composite);
//
//		tableViewer.setContentProvider(new IStructuredContentProvider<Person,MyDomainModel>() {
//
//			public void dispose() {
//
//			}
//
//
//			public Person[] getElements(MyDomainModel inputElement) {
//				Person[] persons = ((MyDomainModel)inputElement).getRoot();
//				Person[] flatPersonsArray = new Person[1];
//				List<Person> flatPersons = new ArrayList<Person>();
//
//				flatTree(persons, flatPersons);
//
//
//				return (Person[]) flatPersons.toArray(flatPersonsArray);
//			}
//
//
//			public void inputChanged(Viewer<MyDomainModel> viewer, MyDomainModel oldInput,
//					MyDomainModel newInput) {
//
//			}
//
//		});
//
//		class PersonFilter extends ViewerFilter{
//
//			@Override
//			public boolean select(Viewer viewer, Object parentElement,
//					Object element) {
//
//				Person person = (Person) element;
//
//				return person.getName().matches(".*e.*");
//			}
//
//		}
//
//		class MySelectionChangedListner implements ISelectionChangedListener{
//
//			public void selectionChanged(SelectionChangedEvent event) {
//				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
//
//				System.out.println(((Person)selection.getFirstElement()).getName());
//			}
//
//		}
//
//		tableViewer.addFilter(new PersonFilter());
//		tableViewer.addSelectionChangedListener(new MySelectionChangedListner());
//
//
//		TableViewerColumn<Person,MyDomainModel> column = new TableViewerColumn<Person,MyDomainModel>(tableViewer, SWT.NONE);
//
//		column.setLabelProvider(new ColumnLabelProvider<Person,MyDomainModel>(){
//			@Override
//			public String getText(final Person element) {
//				// TODO Auto-generated method stub
//				return element.getName();
//			}
//		});
//
//		column.getColumn().setWidth(200);
//
//		column.getColumn().setText("Name:");
//		column.setEditingSupport(new FirstNameEditingSupport(tableViewer));
//
//
//
//		column = new TableViewerColumn<Person,MyDomainModel>(tableViewer, SWT.NONE);
//
//		column.setLabelProvider(new ColumnLabelProvider<Person,MyDomainModel>(){
//			@Override
//			public String getText(Person element) {
//				// TODO Auto-generated method stub
//				return element.getBirthdate().toString();
//			}
//		});
//
//		column.getColumn().setWidth(200);
//
//		column.getColumn().setText("Date:");
//
//
//
//		tableViewer.setInput(new MyDomainModel());
//
//		tableViewer.refresh();
//	}
//
//	private void flatTree(Object[] persons, List<Person> flatPersons){
//		for (int i = 0; i < persons.length; i++) {
//			Person person = (Person) persons[i];
//			flatPersons.add(person);
//			if(person.getChildren() != null){
//				flatTree(person.getChildren().toArray(),flatPersons);
//			}
//		}
//	}
//
//
//	public class FirstNameEditingSupport extends EditingSupport<Person,MyDomainModel,String> {
//
//		  private final TableViewer<Person,MyDomainModel> viewer;
//
//		  public FirstNameEditingSupport(TableViewer<Person,MyDomainModel> viewer) {
//		    super(viewer);
//		    this.viewer = viewer;
//		  }
//
//		  @Override
//		  protected CellEditor<Person,String> getCellEditor(Person element) {
//		    return new TextCellEditor(viewer.getTable());
//		  }
//
//		  @Override
//		  protected boolean canEdit(Person element) {
//		    return true;
//		  }
//
//		  @Override
//		  protected String getValue(Person element) {
//		    return element.getName();
//		  }
//
//		  @Override
//		  protected void setValue(Person element, String value) {
//		    element.setName(value);
//		    viewer.update(element, null);
//		  }
//		}

	@Focus
	public void onFocus() {
		// TODO Your code here
	}

}