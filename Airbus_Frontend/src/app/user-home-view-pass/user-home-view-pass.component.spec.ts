import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserHomeViewPassComponent } from './user-home-view-pass.component';

describe('UserHomeViewPassComponent', () => {
  let component: UserHomeViewPassComponent;
  let fixture: ComponentFixture<UserHomeViewPassComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UserHomeViewPassComponent]
    });
    fixture = TestBed.createComponent(UserHomeViewPassComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
