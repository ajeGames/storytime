import React from 'react';
import TitleInput from './TitleInput';

class Editor extends React.Component {

  render() {
    return (
        <div id="editor">
          <h1>Editor</h1>
          <form>
            <ul>
              <li><TitleInput /></li>
              <li>
                <label>Author:</label> <input type="text" ng-model="editorCtrl.draftSummary.author"/>
              </li>
              <li>
                <label>Tag Line:</label> <input type="text" ng-model="editorCtrl.draftSummary.tagLine"/>
              </li>
              <li>
                <label>Description:</label>
                            <textarea ng-model="editorCtrl.draftSummary.about"></textarea>
              </li>
              <li>
                <label>Opening Scene Teaser:</label>
                <input type="text" ng-model="editorCtrl.draftSummary.firstChapter.teaser"/>
              </li>
              <li>
                <button ng-click="editorCtrl.saveDraftSummary()">Save Story</button>
                (Key: editorCtrl.draftSummary.key)<br/>
                <a ng-hide="editorCtrl.draftSummary.key === undefined"
                   ng-href="#/editor/editorCtrl.draftSummary.key/editorCtrl.draftSummary.firstChapter.targetChapterId">Edit
                  First Chapter</a>
              </li>
            </ul>
          </form>
        </div>
    );
  }
}

export default Editor;
