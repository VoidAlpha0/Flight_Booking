import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserHomeAddPassComponent } from './user-home-add-pass.component';

describe('UserHomeAddPassComponent', () => {
  let component: UserHomeAddPassComponent;
  let fixture: ComponentFixture<UserHomeAddPassComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UserHomeAddPassComponent]
    });
    fixture = TestBed.createComponent(UserHomeAddPassComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
