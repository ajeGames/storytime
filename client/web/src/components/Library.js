import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { storySummaries } from '../apidata/storySummaries';
import { Container, Row, Col, Card, CardTitle, CardText, CardSubtitle } from 'reactstrap';

const StoryCard = (props) => (
  <Col sm="4">
    <Card block outline color="primary"
      className="text-center"
      style={{marginBottom: 2 + 'em', padding: 0.5 + 'em', border: 'solid 1px gray'}}>
      <CardTitle>
        <Link
          to={ `/reader/${ props.story.key }` }
        >
          { props.story.title }
        </Link>
      </CardTitle>
      <CardSubtitle><em>by { props.story.author }</em></CardSubtitle>
      <CardText>{ props.story.about }</CardText>
      <Link
        className="btn btn-info"
        role="button"
        to={ `/reader/${ props.story.key }` }
      >
        { props.story.tagLine }
      </Link>
    </Card>
  </Col>
);

function CardCatalog(props) {
  return (
    <Row>
      { props.stories.map((story) => <StoryCard key={ story.key } story={ story } />) }
    </Row>
  );
}

class Library extends Component {
  render() {
    const summaries = storySummaries;

    return (
      <div className="panel panel-default">
        <div className="panel-heading">
          <h3 className="text-center panel-title">Welcome to the Library. Choose a Story.</h3></div>
        <div className="panel-body">
          <Container fluid>
            <CardCatalog stories={ summaries } />
          </Container>
        </div>
      </div>
    );
  }
}

export default Library;
