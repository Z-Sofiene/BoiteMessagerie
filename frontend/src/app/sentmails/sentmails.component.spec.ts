import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SentmailsComponent } from './sentmails.component';

describe('SentmailsComponent', () => {
  let component: SentmailsComponent;
  let fixture: ComponentFixture<SentmailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SentmailsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SentmailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
