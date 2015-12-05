import React from 'react';

class Home extends React.Component {
  render() {
    return (
      <div id="home">
        <div id="header" className="row">
          <h2 className="header">Story Catalog</h2>
          <div className="instruction">Pick an adventure from the catalog.</div>
        </div>
        <div id="main" class="row scroll-y">
          !!! Catalog goes here !!!
        </div>
        <div id="footer" class="row">
          Footer !! Footer !! Footer !! Footer !! Footer
        </div>
      </div>
    );
  }
}

export default Home;

/*
 <div className="summary" ng-repeat="story in catCtrl.catalog">
 <div>
 <span class="title"><a href="#/reader/{{story.key}}">{{story.title}}</a></span>
 <span class="author">by {{story.author}}</span>
 <a ng-href="#/editor/{{story.key}}"><img src="img/icon-edit.jpg" width="32px"></a>
 <span ng-click="catCtrl.deleteStory(story.key)"><img src="img/icon-delete.png" width="24px"></span>
 </div>
 <div class="tagline">{{story.tagLine}}</div>
 <div class="description">{{story.about}}</div>
 </div>
*/
