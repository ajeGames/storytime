import React from 'react';
import ChapterPicker from './ChapterPicker';
import ChapterDetailEditor from './ChapterDetailEditor';

const ChapterEditor = () => (
  <div>
    <h2>Chapter Editor</h2>
    <ChapterPicker />
    <ChapterDetailEditor />
  </div>
);

export default ChapterEditor;
