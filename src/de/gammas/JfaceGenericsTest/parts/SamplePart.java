/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package de.gammas.JfaceGenericsTest.parts;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

public class SamplePart {


	@PostConstruct
	public void createComposite(Composite parent) {
		parent.setLayout(new GridLayout());
		ComboViewer<Person> comboViewer = new ComboViewer<Person>(parent);
		List<Person> content = new ArrayList<Person>();		
		
		content.add(new Person("Peter", new Date()));
		content.add(new Person("Hans", new Date()));
		
		comboViewer.setContentProvider(ArrayContentProvider.getInstance());
		
		comboViewer.setLabelProvider(new LabelProvider<Person>(){
			@Override
			public String getText(Person element) {
				// TODO Auto-generated method stub
				return element.getName();
			}
		});
		comboViewer.setInput(content);
 		
		
	}

	@Focus
	public void setFocus() {
	}
}
