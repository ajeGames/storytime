import React from 'react';
import { Link } from 'react-router-dom';
import { Container, Row, Col, Card, CardTitle, CardText, CardSubtitle, Button } from 'reactstrap';

const StoryCard = ({ story }) => (
  <Col sm="4">
    <Card block outline color="primary"
      className="text-center"
      style={{marginBottom: 2 + 'em', padding: 0.5 + 'em', border: 'solid 1px gray'}}>
      <CardTitle>
        <Link
          to={ `/reader/${ story.storyKey }` }
        >
          { story.title }
        </Link>
      </CardTitle>
      <CardSubtitle><em>by { story.author.penName }</em></CardSubtitle>
      <CardText>{ story.about }</CardText>
      <Link
        className="btn btn-info"
        role="button"
        to={ `/reader/${ story.storyKey }` }
      >
        { story.tagLine }
      </Link>
    </Card>
  </Col>
);

const CardCatalog = ({ stories }) => (
  <Container fluid>
    <Row>
      { stories.map((story) => <StoryCard key={ story.storyKey } story={ story } />) }
    </Row>
  </Container>
);

const Library = ({ summaries, loading, loadStories }) => {
  const message = (loading) ? "Stories are loading. Please wait." : "Not loading.";

  let catalog;
  if (!summaries || summaries.length === 0) {
    catalog = <Button onClick={ loadStories }>Load Stories</Button>
  } else {
    catalog = <CardCatalog stories={ summaries } />
  }

  return (
    <div className="panel panel-default">
      <div className="panel-heading">
        <h3 className="text-center panel-title">Welcome to the Library.</h3></div>
      <div className="panel-body">
        <p>{ message }</p>
        { catalog }
      </div>
    </div>
  )
};

export default Library;
