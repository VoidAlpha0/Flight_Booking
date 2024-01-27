import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserHomeUpdateUserComponent } from './user-home-update-user.component';

describe('UserHomeUpdateUserComponent', () => {
  let component: UserHomeUpdateUserComponent;
  let fixture: ComponentFixture<UserHomeUpdateUserComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UserHomeUpdateUserComponent]
    });
    fixture = TestBed.createComponent(UserHomeUpdateUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
