import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserHomeViewFlightsComponent } from './user-home-view-flights.component';

describe('UserHomeViewFlightsComponent', () => {
  let component: UserHomeViewFlightsComponent;
  let fixture: ComponentFixture<UserHomeViewFlightsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UserHomeViewFlightsComponent]
    });
    fixture = TestBed.createComponent(UserHomeViewFlightsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
