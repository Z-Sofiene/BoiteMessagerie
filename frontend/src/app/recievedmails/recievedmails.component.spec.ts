import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecievedmailsComponent } from './recievedmails.component';

describe('RecievedmailsComponent', () => {
  let component: RecievedmailsComponent;
  let fixture: ComponentFixture<RecievedmailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [RecievedmailsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RecievedmailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
