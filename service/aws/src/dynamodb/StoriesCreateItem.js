const admin = require('./CommonAdmin');
const handleResponse = admin.handleResponse;

const params = {
  TableName: 'Stories',
  Item: {
    StoryID: 'kjkjkj3423423',
  },
};

admin.docClient.put(params, handleResponse);
