import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserHomeShowTicketsComponent } from './user-home-show-tickets.component';

describe('UserHomeShowTicketsComponent', () => {
  let component: UserHomeShowTicketsComponent;
  let fixture: ComponentFixture<UserHomeShowTicketsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UserHomeShowTicketsComponent]
    });
    fixture = TestBed.createComponent(UserHomeShowTicketsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
