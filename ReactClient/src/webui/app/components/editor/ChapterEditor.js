import React from 'react';
import ChapterPicker from './ChapterPicker';
import ChapterDetailEditor from './ChapterDetailEditor';

class ChapterEditor extends React.Component {

  render() {
    return (
        <div>
          <h2>Chapter Editor</h2>
          <ChapterPicker />
          <ChapterDetailEditor />
        </div>
    );
  }
}

export default ChapterEditor;
