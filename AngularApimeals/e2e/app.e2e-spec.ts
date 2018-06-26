import { ApimealsappPage } from './app.po';

describe('apimealsapp App', function() {
  let page: ApimealsappPage;

  beforeEach(() => {
    page = new ApimealsappPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
