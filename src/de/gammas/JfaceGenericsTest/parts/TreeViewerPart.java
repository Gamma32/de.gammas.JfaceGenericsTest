package de.gammas.JfaceGenericsTest.parts;

import java.util.Date;

import javax.inject.Inject;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import de.gammas.JfaceGenericsTest.model.Person;

public class TreeViewerPart {
	@Inject
	public TreeViewerPart(Composite parent) {

		TreeViewer treeViewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL);
		treeViewer.setContentProvider(new MyViewContentProvider());
		treeViewer.setLabelProvider(new MyLabelProvider());
		treeViewer.setInput(generateInput());
	}

	class MyViewContentProvider implements ITreeContentProvider {

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

		}

		public Object[] getElements(Object inputElement) {
			return (Object[]) inputElement;
		}

		public Object[] getChildren(Object parentElement) {
			// TODO Auto-generated method stub
			return ((Person) parentElement).getChildren().toArray();
		}

		public Object getParent(Object element) {
			// TODO Auto-generated method stub
			return null;
		}

		public boolean hasChildren(Object element) {
			if (((Person) element).getChildren() == null
					|| ((Person) element).getChildren().size() == 0) {

				return false;
			}

			return true;
		}

	}

	class MyLabelProvider extends LabelProvider {
		@Override
		public String getText(Object element) {
			return ((Person) element).getName();
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

	@Focus
	public void onFocus() {
		// TODO Your code here
	}

}