/*
 * This file is part of the Sejda source code
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.sejda.cli;

import org.junit.Test;
import org.sejda.model.parameter.ExtractByOutlineParameters;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the ExtractByBookmarksTask command line interface
 * 
 */
public class ExtractByBookmarksTaskTest extends AbstractTaskTest {

    public ExtractByBookmarksTaskTest() {
        super(TestableTask.EXTRACT_BY_BOOKMARKS);
    }

    @Test
    public void bookmarksLevel_Specified() {
        ExtractByOutlineParameters parameters = defaultCommandLine().with("-l", "3").invokeSejdaConsole();
        assertEquals(3, parameters.getLevel());
    }

    @Test
    public void mandatoryParams() {
        defaultCommandLine().without("-l").assertConsoleOutputContains("Option is mandatory: --bookmarkLevel");
    }

    @Test
    public void matchingRegExp_Specified() {
        ExtractByOutlineParameters parameters = defaultCommandLine().with("--matchingRegEx", "[Chapter*]")
                .invokeSejdaConsole();
        assertEquals("[Chapter*]", parameters.getMatchingTitleRegEx());
    }
}