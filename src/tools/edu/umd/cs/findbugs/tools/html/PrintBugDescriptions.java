/*
 * Generate HTML file containing bug descriptions
 * Copyright (C) 2004, University of Maryland
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package edu.umd.cs.findbugs.tools.html;

import edu.umd.cs.findbugs.BugPattern;
import edu.umd.cs.findbugs.DetectorFactoryCollection;
import edu.umd.cs.findbugs.I18N;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import java.util.Iterator;

public abstract class PrintBugDescriptions {
	public void print() throws IOException {
		// Ensure bug patterns are loaded
		DetectorFactoryCollection.instance();

		prologue();

		Iterator<BugPattern> i = I18N.instance().bugPatternIterator();
		while (i.hasNext()) {
			BugPattern bugPattern = i.next();
			emit(bugPattern);
		}

		epilogue();
	}

	protected abstract void prologue() throws IOException;

	protected abstract void emit(BugPattern bugPattern);

	protected abstract void epilogue() throws IOException;
}

// vim:ts=3
