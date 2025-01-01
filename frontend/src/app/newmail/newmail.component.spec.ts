import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewmailComponent } from './newmail.component';

describe('NewmailComponent', () => {
  let component: NewmailComponent;
  let fixture: ComponentFixture<NewmailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [NewmailComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewmailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
