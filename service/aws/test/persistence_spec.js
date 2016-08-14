import { expect } from 'chai';
import { isAlive } from './src/dynamodb/CommonAdmin';

describe('Common Admin', () => {
  it('Can tell that DynamoDB is responsive', () => {
    expect(isAlive()).is.true;
  });
});
