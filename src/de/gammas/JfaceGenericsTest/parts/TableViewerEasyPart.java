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

public class TableViewerEasyPart {
	@Inject
	public TableViewerEasyPart(Composite composite) {

		List<Person> content = new ArrayList<Person>();
	    content.add(new Person("Peter", new Date()));
	    content.add(new Person("Lars", new Date()));

		TableViewer<Person,List<Person>> tableViewer = new TableViewer<Person,List<Person>>(composite);

		tableViewer.setContentProvider(new IStructuredContentProvider<Person,List<Person>>() {

			public void dispose() {

			}

			public Person[] getElements(List<Person> inputElement) {
				return (Person[]) inputElement.toArray();
			}

			public void inputChanged(Viewer<List<Person>> viewer, List<Person> oldInput,
					List<Person> newInput) {
			}

		});


		class MySelectionChangedListner implements ISelectionChangedListener{

			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();

				System.out.println(((Person)selection.getFirstElement()).getName());
			}

		}

		tableViewer.addSelectionChangedListener(new MySelectionChangedListner());

		TableViewerColumn<Person,List<Person>> column = new TableViewerColumn<Person,List<Person>>(tableViewer, SWT.NONE);

		column.setLabelProvider(new ColumnLabelProvider<Person,List<Person>>(){
			@Override
			public String getText(final Person element) {
				return element.getName();
			}
		});

		column.getColumn().setWidth(200);

		column.getColumn().setText("Name:");


		column = new TableViewerColumn<Person,List<Person>>(tableViewer, SWT.NONE);

		column.setLabelProvider(new ColumnLabelProvider<Person,List<Person>>(){
			@Override
			public String getText(Person element) {
				// TODO Auto-generated method stub
				return element.getBirthdate().toString();
			}
		});

		column.getColumn().setWidth(200);

		column.getColumn().setText("Date:");

		tableViewer.setInput(content);
	}




	@Focus
	public void onFocus() {
		// TODO Your code here
	}

}