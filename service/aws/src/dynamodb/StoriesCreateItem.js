import admin from './CommonAdmin';

const params = {
  TableName: 'Stories',
  Item: {
    StoryID: 'kjkjkj3423423'
  }
};

admin.docClient.put(params, admin.handleResponse);
