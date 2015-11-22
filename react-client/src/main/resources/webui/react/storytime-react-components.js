/*
Components:

  Reader
    Title Bar
    Chapter
    SignPost
      Sign
    Ending (suggestions for what to do next)
      Suggestion
*/

var TitleBar = React.createClass({
  render: function() {
    return (
      <div><span class="title">{this.props.title}</span> <span class="author">by {this.props.author}</span></div>
    );
  }
});

var Chapter = React.createClass({
  render: function() {
    return (
      <div class="chapterTitle">{this.props.chapter.title</div>
      <div id="prose">
        {this.props.chapter.prose}
      </div>
    );
  }
});

var SignPost = React.createClass({
  render: function() {
    return (
      <div id="nextChapters">
          <div class="nextChapterOption"><a href=".">Go to the right.</a></div>
          <div class="nextChapterOption"><a href=".">Go to the left.</a></div>
      </div>
    );
  }
});

var Reader = React.createClass({
  render: function() {
    return (
      <div id="header" class="row">
        <TitleBar title="Tales of Two Cities" author="Charles Dickens" />
      </div>
      <div id="main" class="row scroll-y">
        <Chapter chapter={chapter} />
        <SignPost next={chapter.nextChapterOptions} />
      </div>
    );
  }
})