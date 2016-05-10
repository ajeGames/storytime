import React from 'react';
import { connect } from 'react-redux';
import StorySummaryEditor from './StorySummaryEditor';

/*
 This is the top-level container component for editing stories.  This editor consists of the
 following parts:

 1. The summary, including fields for title, author, description, date published, etc., that
 can be in read-only or edit mode.  New summaries start in edit mode.  Existing summaries
 start in read-only mode.  There is a button to enter edit mode or save and enter read-only
 mode.  Changes to fields are preserved in draft copy of summary. Saving commits changes to
 server.  In edit mode, a 'Cancel' button drops edits, returning to read-only mode. Any
 action to leave the summary while editing other than 'Cancel' results in an implicit save.
 Commits are only sent to the server if changes were made.

 2. Chapter management, for creating new chapters, selecting chapters to edit, and deleting
 chapters.
 3. A chapter in draft mode that is being edited.  Chapters consist of a header and prose.
 4. A sign post editor for the selected chapter that manages links to other chapters and the
 "teaser" text that explains the choice.

 Editor is a subscriber to the Redux store.

 import ChapterEditor from './ChapterEditor';
 <ChapterEditor />
 */

const Editor = (props) => (
  <div className="editor">
    <header>Create Your Story (Editor)</header>
    <StorySummaryEditor summary={props.draftSummary} />
  </div>
);

Editor.propTypes = {
  draftSummary: React.PropTypes.object,
};

function mapStateToProps(state) {
  return {
    draftSummary: state.getIn(['draft', 'summary']),
  };
}

export const EditorContainer = connect(mapStateToProps)(Editor);
