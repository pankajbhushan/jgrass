import { JgrassUiPage } from './app.po';

describe('jgrass-ui App', function() {
  let page: JgrassUiPage;

  beforeEach(() => {
    page = new JgrassUiPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
