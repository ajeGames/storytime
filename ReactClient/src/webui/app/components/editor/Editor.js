import React from 'react';
import StorySummaryEditor from './StorySummaryEditor';

/*
  This is the top-level component for editing stories.  A story has a few parts:

    1. The summary, including title, author, description, date published, etc.
    2. One or more chapters.

  A chapter has a few parts as well:

    1. The chapter number and title.
    2. The prose.
    3. A signpost with any number of signs pointing to subsequent chapters.
      3a. A sign has a description of the choice being offered to the reader.
      3b. During editing, a sign can point to an existing chapter or indicate a new chapter to be created.

 import ChapterEditor from './ChapterEditor';
 <ChapterEditor />
 */

class Editor extends React.Component {

  constructor() {
    super();
  }

  render() {
    return (
        <div id="editor">
          <h1>Create Your Story</h1>
          <StorySummaryEditor />
        </div>
    );
  }
}

export default Editor;
