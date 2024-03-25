import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormulariosClientesComponent } from './formularios-clientes.component';

describe('FormulariosClientesComponent', () => {
  let component: FormulariosClientesComponent;
  let fixture: ComponentFixture<FormulariosClientesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [FormulariosClientesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FormulariosClientesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
